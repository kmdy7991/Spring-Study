package intro.spring.repository;

import intro.spring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcMemberRepository implements MemberRepository {
    private final DataSource dataSource;

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        String sql = "insert into member (name) values (?)";

        Connection connection = getConnection();

        ResultSet rs = null;

        try (
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setString(1, member.getName());
            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                member.setId(rs.getLong(1));
            } else {
                throw new SQLException("Failed to insert member");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionClose(connection, rs);
        }

        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        String sql = "select * from member where id = ?";

        Connection connection = getConnection();
        ResultSet rs = null;

        try (
                PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong(1));
                member.setName(rs.getString(2));

                return Optional.of(member);
            } else {
                throw new SQLException("Failed to insert member");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionClose(connection, rs);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        String sql = "select * from member where name = ?";

        Connection connection = getConnection();
        ResultSet rs = null;

        try (
                PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong(1));
                member.setName(rs.getString(2));

                return Optional.of(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionClose(connection, rs);
        }

        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        String sql = "select * from member";

        Connection connection = getConnection();

        ResultSet rs = null;

        try (
                PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            rs = stmt.executeQuery();

            List<Member> members = new ArrayList<>();
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));

                members.add(member);
            }

            return members;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionClose(connection, rs);
        }

        return List.of();
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    private void connectionClose(Connection con, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (con != null) {
            close(con);
        }
    }

    private void close(Connection con) {
        DataSourceUtils.releaseConnection(con, dataSource);
    }
}

package webinterface.webinteractor.Model;

public interface DbInterface {
    boolean connect(String database, String username, String password) throws DbException;
    boolean disconnect(String database) throws DbException;

}

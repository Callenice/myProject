package webinterface.webinteractor.Model;

public interface DbInterface {
    boolean connect(String database, String username, String password) throws DbException;
    boolean disConnect(String database) throws DbException;

}

package entity;

/**
 * @description: 日志实体
 */
public class Log {
    private int id;
    private String operator;
    private String operation;
    private String gmt_create;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", operator='" + operator + '\'' +
                ", operation='" + operation + '\'' +
                ", gmt_create='" + gmt_create + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }
}

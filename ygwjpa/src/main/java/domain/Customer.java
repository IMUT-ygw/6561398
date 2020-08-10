package domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nmtl_ygw
 * @Description
 *  //@Entity注解  声明此类是实体类
 *  //@Table注解   声明数据库表名   name属性写表名
 *  //@Id  声明主键的配置
 *  //@GeneratedValue 配置主键生成的策略
 *      属性strategy = GenerationType.IDENTITY  自增
 *      属性strategy = GenerationType.TABLE  数据库会多生成一个表  主表id不自增 会创建一个新表保存id的自增信息
 *      属性strategy = GenerationType.AUTO  程序自动帮我们选择主键生成策略
 *
 *
 *  //@Column 配置属性和字段的映射关系  属性name 代表数据库字段名
 *
 *
 * @date 2020/5/20 20:04
 */
@Entity
@Table(name = "cst_customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "cust_id")
    private Long custId;
    @Column(name = "cust_name")
    private String custName;
    @Column(name = "cust_source")
    private String custSource;
    @Column(name = "cust_industry")
    private String custIndustry;
    @Column(name = "cust_level")
    private String custLevel;
    @Column(name = "cust_address")
    private String custAddress;
    @Column(name = "cust_phone")
    private String custPhone;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}

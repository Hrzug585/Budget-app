package com.project.budgetapp.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity(name="images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long image_id;
    @Column(name = "expense_id")
    private long expenseId;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] pic;

    public Image() {}
    public Image(long expenseId, byte[] pic) {
        this.expenseId = expenseId;
        this.pic = pic;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(long ExpenseId) {
        this.expenseId = ExpenseId;
    }
}

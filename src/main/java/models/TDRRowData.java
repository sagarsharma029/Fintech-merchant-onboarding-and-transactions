package models;

public class TDRRowData {

    private String paymentType;
    private String mopType;

    public TDRRowData(String paymentType, String mopType) {
        this.paymentType = paymentType;
        this.mopType = mopType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getMopType() {
        return mopType;
    }

    @Override
    public String toString() {
        return paymentType + " - " + mopType;
    }
}
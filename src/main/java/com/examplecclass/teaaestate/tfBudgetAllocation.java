package com.examplecclass.teaaestate;

public class tfBudgetAllocation {
    private String trningprgmname;
    private int prtcpnt, trnerfee,mtrlcost,venuecost,rfrshmts;

    public tfBudgetAllocation() {
    }

    public tfBudgetAllocation(String trningprgmname, int prtcpnt, int trnerfee, int mtrlcost, int venuecost, int rfrshmts) {
        this.trningprgmname = trningprgmname;
        this.prtcpnt = prtcpnt;
        this.trnerfee = trnerfee;
        this.mtrlcost = mtrlcost;
        this.venuecost = venuecost;
        this.rfrshmts = rfrshmts;
    }

    public String getTrningprgmname() {
        return trningprgmname;
    }

    public void setTrningprgmname(String trningprgmname) {
        this.trningprgmname = trningprgmname;
    }

    public int getPrtcpnt() {
        return prtcpnt;
    }

    public void setPrtcpnt(int prtcpnt) {
        this.prtcpnt = prtcpnt;
    }

    public int getTrnerfee() {
        return trnerfee;
    }

    public void setTrnerfee(int trnerfee) {
        this.trnerfee = trnerfee;
    }

    public int getMtrlcost() {
        return mtrlcost;
    }

    public void setMtrlcost(int mtrlcost) {
        this.mtrlcost = mtrlcost;
    }

    public int getVenuecost() {
        return venuecost;
    }

    public void setVenuecost(int venuecost) {
        this.venuecost = venuecost;
    }

    public int getRfrshmts() {
        return rfrshmts;
    }

    public void setRfrshmts(int rfrshmts) {
        this.rfrshmts = rfrshmts;
    }

    @Override
    public String toString() {
        return "tfBudgetAllocation{" +
                "trningprgmname='" + trningprgmname + '\'' +
                ", prtcpnt=" + prtcpnt +
                ", trnerfee=" + trnerfee +
                ", mtrlcost=" + mtrlcost +
                ", venuecost=" + venuecost +
                ", rfrshmts=" + rfrshmts +
                '}';
    }
}

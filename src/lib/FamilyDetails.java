package lib;

import java.util.LinkedList;
import java.util.List;

public class FamilyDetails {
    private String spouseName;
    private String spouseIdNumber;
    private List<String> childNames;
    private List<String> childIdNumbers;
    
    public FamilyDetails() {
        childNames = new LinkedList<>();
        childIdNumbers = new LinkedList<>();
    }
    
    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }
    
    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }
    
    public boolean hasSpouse() {
        return spouseIdNumber != null && !spouseIdNumber.equals("");
    }
    
    public int getChildCount() {
        return childIdNumbers.size();
    }
}

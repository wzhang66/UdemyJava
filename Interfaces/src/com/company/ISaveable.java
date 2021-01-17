package com.company;

import java.util.ArrayList;
import java.util.List;

public interface ISaveable {
    public List<String> write();
    public void read(List<String> saveValue);
}

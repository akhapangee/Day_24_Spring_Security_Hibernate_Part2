package com.akhilesh.webapp.data;

import java.util.List;

/**
 *
 * @author Akhilesh
 */
public class ResponseData<T> {
    private List<T> data;

    public ResponseData() {
    }
    
    

    public ResponseData(List<T> data) {
        this.data = data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
    
    public List<T> getData(){
        return  data;
    }
    
    
}

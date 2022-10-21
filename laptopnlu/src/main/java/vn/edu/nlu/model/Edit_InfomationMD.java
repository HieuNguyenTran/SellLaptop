package vn.edu.nlu.model;

import vn.edu.nlu.beans.User;
import vn.edu.nlu.entity.Edit_Information_Entity;

import java.sql.Date;
import java.util.StringTokenizer;

public class Edit_InfomationMD {
    public Date date(String date){
        StringTokenizer tk= new StringTokenizer(date,"-");
        int year= Integer.parseInt(tk.nextToken());
        int mon= Integer.parseInt(tk.nextToken());
        int day= Integer.parseInt(tk.nextToken());
        return new Date(year,mon, day);
    }
    public void UpdateUser(User userChange, String username){
        new Edit_Information_Entity().UpdateUser(userChange,username);
    }

}

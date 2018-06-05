package br.edu.utfpr.web2.model;

import java.util.Date;

public class Photo {
    private int id;
    private String identifierPhoto;
    private Date addedPhotoDate;

    public Photo() {

    }
    public Photo(String identifier) throws Exception{
        this();
        this.setAddedPhotoDate(addedPhotoDate);
        this.setIdentifierPhoto(identifierPhoto);
    }
    public void setIdentifierPhoto(String identifierPhoto) throws Exception{
        if(identifierPhoto.length() > 20){
            this.identifierPhoto = identifierPhoto;
        } else {
            throw new Exception("Name must be less than 20 characteres");
        }
    }
    public void setAddedPhotoDate(Date addedPhotoDate2) {
        this.addedPhotoDate = new Date();
    }
    public Date getAddedDate() {
        return this.addedPhotoDate; 
    }
    public String getIdentifier() {
        return this.identifierPhoto;
    }
}

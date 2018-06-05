package br.edu.utfpr.web2.model;

public class Album {
	private Photo photo;
	private String title;
	//private int id;
	
	public Album() {

	}

	public Album(Photo photo) throws Exception {
		this();
		this.setPhoto(photo);
		this.setIdentifier(title);
	}

	public void setPhoto(Photo photo) throws Exception {
		if (!photo.equals(null)) {
			this.photo = photo;
		} else {
			throw new Exception("Photo is null");
		}
	}

	public void setIdentifier(String title) {
		this.title = title;
	}

	public Photo getPhoto() {
		return this.photo;
	}
}
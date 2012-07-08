package covers;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy; 
import javax.jdo.annotations.IdentityType; 
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Book {

	@PrimaryKey 
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) public Long id;
	public Key key;
	
	@Persistent public String title; 
	@Persistent public String author; 
	@Persistent public String praise;
	@Persistent public String reviewer;
	@Persistent public String coverURL;
	@Persistent public String amazonLink;
	@Persistent public String genre;
	@Persistent public Text description;

	@Persistent
    @Extension(vendorName="datanucleus", key="gae.unindexed", value="true")
    public String imageType;

    @Persistent
    public Blob image;
	
    public Book(String author, String title, String amazonLink, Text description,
    		String genre, String imageType, byte[] bytes)
	{
		this.author = author;
    	this.title = title;
    	this.amazonLink = amazonLink;
    	this.description = description;
    	this.genre = genre;
		this.imageType = imageType;
		this.image = new Blob(bytes);
	}
    
    public Book(String author, String title, String amazonLink, Text description,
    		String genre, String imageType, byte[] bytes, String praise,
    		String reviewer)
    
	{
		this.title = title;
		this.author = author;
		this.amazonLink = amazonLink;
		this.description = description;
		this.genre = genre;
		this.imageType = imageType;
		this.image = new Blob(bytes);
		this.praise = praise;
		this.reviewer = reviewer;
	}
	
	/** * @return the id */
	public Long getId() {
		return id;
	}
	/**
	@param id the id to set
	*/
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the title
	*/
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 *  @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * @return the genre
	*/
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/**
	 * @return the description
	*/
	public String getDescription() {
		return description.getValue();
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(Text description) {
		this.description = description;
	}
	/**
	 * @return the praise
	 */
	public String getPraise() {
		return praise;
	}
	/** 
	 * @param praise the praise to set
	 */
	public void setPraise(String praise) {
		this.praise = praise;
	}
	/**
	 * @return the reviewer
	 */
	public String getReviewer() {
		return reviewer;
	}
	/** 
	 * @param reviewer the reviewer to set
	 */
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	
	public String getAmazonLink() {
		return amazonLink;
	}
	/** 
	 * @param reviewer the reviewer to set
	 */
	public void setAmazonLink(String amazonLink) {
		this.amazonLink = amazonLink;
	}
	
	public void setCoverURL(String coverURL) {
		this.coverURL = coverURL;
	}
	
	public String getCoverURL() {
		return coverURL;
	}
	
	public String getImageType() {
        return imageType;
    }

	public void setImageType(String imageType) {
        this.imageType = imageType;
    }
	
	public byte[] getImage() {
        if (image == null) {
            return null;
        }

        return image.getBytes();
    }
    
    public void setImage(byte[] bytes) {
        this.image = new Blob(bytes);
    }
}

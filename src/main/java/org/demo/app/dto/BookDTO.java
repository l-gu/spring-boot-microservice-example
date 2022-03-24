package org.demo.app.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class BookDTO {

    private Integer id;

    @NotNull
    @Size(max = 80)
    private String title;

    
    public BookDTO(Integer id, @NotNull @Size(max = 80) String title) {
		super();
		this.id = id;
		this.title = title;
	}
    
	public Integer getId() {
        return id;
    }
    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(final String title) {
        this.title = title;
    }

}

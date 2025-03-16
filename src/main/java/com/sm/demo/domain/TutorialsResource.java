package com.sm.demo.domain;


public class TutorialsResource {
    private Integer id;

    /**
     * 作者
     */
    private String description;

    /**
     * 描述
     */
    private String title;

    /**
     * 地址链接
     */
    private String published;

    public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	/**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }


    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	/**
     * 获取描述
     *
     * @return title - 描述
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置描述
     *
     * @param title 描述
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

}
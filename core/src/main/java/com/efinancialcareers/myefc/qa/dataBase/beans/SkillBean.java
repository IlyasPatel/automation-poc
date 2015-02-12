package com.efinancialcareers.myefc.qa.dataBase.beans;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: d.zakutalin
 * Date: 12.03.14
 * Time: 12:06
 */
public class SkillBean implements Comparable<SkillBean> {

    private Long id;
    private String name;
    private String [] synonyms;
    private String lang;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String[] synonyms) {
        this.synonyms = synonyms;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SkillBean skillBean = (SkillBean) o;

        if (!id.equals(skillBean.id)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public int compareTo(SkillBean anotherInstance) {
        return this.getSynonyms().length -anotherInstance.getSynonyms().length;
    }

    @Override
    public String toString() {
        return "SkillBean{"
                + "id=" + id + ", name='" + name + '\''
                + ", synonyms=" + Arrays.toString(synonyms)
                + '}';
    }
}

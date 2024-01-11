package POJOs;

import java.util.List;

public class Add_UpdatePetPojo {

    public static class Category {
        private Integer id;
        private String name;

        public Category() { }

        public Category(Integer id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        public Integer getId() {return id;}

        public void setId(Integer id) {this.id = id;}

        public String getName() {return name;}

        public void setName(String name) {this.name = name;}

    }

    /*Variables del constructor*/
        private Integer id;
        private Category category;
        private String name;
        private List<String> photoUrls;
        private List<Tag> tags;
        private String status;

        public Add_UpdatePetPojo() {}

    /*Constructor que se utiliza para armar el body*/
        public Add_UpdatePetPojo(Integer id, Category category, String name, List<String> photoUrls, List<Tag> tags, String status) {
            super();
            this.id = id;
            this.category = category;
            this.name = name;
            this.photoUrls = photoUrls;
            this.tags = tags;
            this.status = status;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getPhotoUrls() {
            return photoUrls;
        }

        public void setPhotoUrls(List<String> photoUrls) {
            this.photoUrls = photoUrls;
        }

        public List<Tag> getTags() {
            return tags;
        }

        public void setTags(List<Tag> tags) {
            this.tags = tags;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    public static class Tag {

        private Integer id;
        private String name;

        public Tag() {
        }

        public Tag(Integer id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

package api.restassuredpresets;


    public class Repository {

        public String name;

        public Repository(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRepoName() {
            return name;
        }
    }
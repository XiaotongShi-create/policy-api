/*
gcloud auth application-default login
gcloud auth login --cred-file="/Users/shixiaotong/Desktop/side_projects/gcp_service_account/key.json" 
gcloud config set project etl-elt
gcloud auth list
*/
package io.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "io.*" })
@EntityScan(basePackages = "io.*")
public class PolicyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolicyApplication.class, args);
    }
}

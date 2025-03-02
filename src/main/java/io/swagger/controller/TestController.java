package io.swagger.controller;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.SpannerOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;


@RestController
@RequestMapping("/api/test")
public class TestController {

    @Value("${spring.cloud.gcp.spanner.instance-id}")
    private String instanceId;

    @Value("${spring.cloud.gcp.spanner.database}")
    private String databaseId;

    @GetMapping("/spanner")
    public String testSpannerConnection() {
        SpannerOptions options = SpannerOptions.newBuilder().build();
        Spanner spanner = options.getService();
        DatabaseClient dbClient = spanner.getDatabaseClient(
            DatabaseId.of(options.getProjectId(), instanceId, databaseId));

        try (ResultSet resultSet = dbClient.singleUse().executeQuery(Statement.of("SELECT 1"))) {
            if (resultSet.next()) {
                return "Spanner connection successful!";
            } else {
                return "Spanner connection failed!";
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
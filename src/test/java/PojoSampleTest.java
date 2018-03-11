import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.issue.Fields;
import json.issue.Issue;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class PojoSampleTest {

    @Test
    public void sampleTest() {
        ObjectMapper mapper = new ObjectMapper();

        Fields fields = new Fields();
        fields.setAssignee("Mari");
        fields.setIssueType("Story");
        fields.setProject("QAAUT-325");
        fields.setSummary("Summary for sad story");
        fields.setDescription("Smth that describe our story");

        Issue issue = new Issue(fields);

        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(issue);
            try {
                mapper.writeValue(new File("/Users/macbook/***/test.json"), issue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonInString);
    }

}

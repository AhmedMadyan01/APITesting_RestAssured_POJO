package api.pojo.responses.guided_journals;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class JournalContent {
    private String title;
    private String color;
    private List<GuidedJournalQuestions> guidedJournalQuestions;
    private String contentId;
    private String guidedJournalNumber;
}
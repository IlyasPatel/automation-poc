Meta:
@tag feature:Job Application

Narrative:
As a new jobseeker
I would like to apply for jobs
So I can find a new job. The job has a questionnaire.

Scenario: From the SRP, a new jobseeker selects a job to apply to and then registers a normal account. This particular job has a questionnaire and the jobseeker creates a new cover letter for this particular application only.

Given I want to apply for a specific job
When I register a new account to apply for this job
Then I am taken to the "Questionnaire" page as this job has a questionnaire
And I enter my <answers> questionnaire answers
And I am taken to the "Apply for a Job" page
And I upload my resume <document>
And I add a cover letter titled <coverLetterTitle> and text <coverLetterText>
And I enter my personal details
And then apply for the job
Then my application is sent to the recruiter successfully
When I go to the application history page
Then I can see my application at the top of the list on page 1
And my cover letter <coverLetterTitle> is shown with the application

Examples:
|answers|document|coverLetterTitle|coverLetterText|
|Valid|SmokeTestResumeInDocFormat.doc|Letter Title|Cover Letter Text with lots of words to see if spaces are still displayed.|
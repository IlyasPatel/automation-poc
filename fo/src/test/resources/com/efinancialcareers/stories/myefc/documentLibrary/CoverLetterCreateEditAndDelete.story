Meta:

Narrative:
As a jobseeker
I would like to update my cover letter

Scenario: Create, edit and delete a cover letter

Given I directly go to the document library URL and successfully login with <email> and <password>
When I create a cover letter with title <title> and <text> and click "Save"
Then my cover letter is created
When I update my cover letter with title <updatedTitle> and <updatedText> and click "Save"
Then my cover letter is updated
When I delete my cover letter
Then my cover letter is deleted

Examples:
|email|password|title|text|updatedTitle|updatedText|
|testuser{dataset}@test.com|testing123|Cover Letter Title|Cover Letter Text|Cover Letter Updated|Cover Letter Text Updated|
Meta:

Narrative:
As a jobseeker
I would like to upload my resume
So I can complete my profile

Scenario: Uploading different resume file-formats (.docx, .pdf, .txt, .doc)

Given I directly go to the document library URL and successfully login with <email> and <password>
When I select a resume to upload <document>
Then the file format is first validated (file size under 3MB, Accepted Document Format (.doc, .docx, .pdf, .txt, .rtf))
When I upload the resume for it to be saved against my account
Then it is passed through Burning Glass, virus scan, image and html creation
And it is successfully uploaded to my document library

Examples:
|email|password|document|
|test(dataset)@test.com|testing123|SmokeTestResumeInDocxFormat.docx|
|test(dataset)@test.com|testing123|SmokeTestResumeInPDFFormat.pdf|
|test(dataset)@test.com|testing123|SmokeTestResumeInTxtFormat.txt|
|test(dataset)@test.com|testing123|SmokeTestResumeInDocFormat.doc|




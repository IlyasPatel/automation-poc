Meta:

Narrative:
As a Tester
I would like to perform boundary testing for resume upload

Scenario: Uploading a resume which is a non supported file format

Given I directly go to the document library URL and successfully login with <email> and <password>
When I select a resume with a non-supported file format to upload (<document>)
Then I am notified that the file extension is not supported
And No Resume is uploaded

Examples:
|email|password|document|
|test(dataset)@test.com|testing123|SmokeTestNonSupportedResume.xlsx|

Scenario: Uploading a resume which is slightly over 3MB

Given I directly go to the document library URL and successfully login with <email> and <password>
When I select a large resume to upload <document>
Then I am notified that the file size is too large
And No Resume is uploaded

Examples:
|email|password|document|
|test(dataset)@test.com|testing123|SmokeTestResumeSlightlyOver3MB.doc|

Scenario: Uploading a resume which is slightly under 3MB

Given I directly go to the document library URL and successfully login with <email> and <password>
When I select a resume to upload <document>
Then the file format is first validated (file size under 3MB, Accepted Document Format (.doc, .docx, .pdf, .txt, .rtf))
When I upload the resume for it to be saved against my account
Then it is passed through Burning Glass, virus scan, image and html creation
And it is successfully uploaded to my document library

Examples:
|email|password|document|
|test(dataset)@test.com|testing123|SmokeTestResumeSlightlyUnder3MB.doc|

Scenario: Uploading an empty resume

Given I directly go to the document library URL and successfully login with <email> and <password>
When I select an empty resume to upload <document>
Then the file format is first validated (file size under 3MB, Accepted Document Format (.doc, .docx, .pdf, .txt, .rtf))
When I upload the resume for it to be saved against my account
Then I receive an error message
And No Resume is uploaded

Examples:
|email|password|document|
|test(dataset)@test.com|testing123|SmokeTestEmptyResume.docx|

Meta:

Narrative:
As a new jobseeker
I would like to automatically create my profile using my resume
So recruiters can see my up-to-date details

Scenario: Create a profile using Burning Glass. Using .docx

Given I register a new account
When I select a cv to upload to pre-populate my profile <document>
Then the file format is first validated (file size under 3MB, Accepted Document Format (.doc, .docx, .pdf, .txt, .rtf))
When I upload the resume for it to be saved against my profile
Then it is passed through Burning Glass, virus scan, image and html creation
And my profile is successfully pre-populated
When I logout and re-login again
Then my profile is still correctly populated

Examples:
|document|myEfcUserBeanName|
|BurningGlassResumeInDocxFormat.docx|MyEfcUserMatchingBurningGlassResumeInDocxFormatBefore|

Scenario: Create a profile using Burning Glass. Using .doc, .pdf, .txt

Given I register a new account
When I select a cv to upload to pre-populate my profile <document>
Then the file format is first validated (file size under 3MB, Accepted Document Format (.doc, .docx, .pdf, .txt, .rtf))
When I upload the resume for it to be saved against my profile
Then it is passed through Burning Glass, virus scan, image and html creation
And my profile is successfully pre-populated

Examples:
|document|myEfcUserBeanName|
|BurningGlassResumeInDocFormat.doc|MyEfcUserMatchingBurningGlassResumeInDocxFormatBefore|
|BurningGlassResumeInPDFFormat.pdf|MyEfcUserMatchingBurningGlassResumeInPDFFormatBefore|
|BurningGlassResumeInDocxFormat.txt|MyEfcUserMatchingBurningGlassResumeInPDFFormatBefore|
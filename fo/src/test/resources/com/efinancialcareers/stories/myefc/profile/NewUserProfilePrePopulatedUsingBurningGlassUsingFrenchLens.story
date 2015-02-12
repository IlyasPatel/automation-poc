Meta:
@tag feature:Fill Profile

Narrative:
As a new jobseeker
I would like to automatically create my profile using my resume
So recruiters can see my up-to-date details

Scenario: Create a profile using Burning Glass. Using .docx, .doc, .pdf, .txt

Given I register a new account
When I select a French cv to upload to pre-populate my profile <document>
Then the file format is first validated (file size under 3MB, Accepted Document Format (.doc, .docx, .pdf, .txt, .rtf))
When I upload the resume for it to be saved against my account
Then it is passed through Burning Glass, virus scan, image and html creation
And my profile is successfully pre-populated
When I logout and re-login again
Then my profile is still correctly populated

Examples:
|document|myEfcUserBeanName|
|BurningGlassResumeFrenchInDocxFormat.docx|MyEfcUserMatchingBurningGlassFrenchResumeBefore|
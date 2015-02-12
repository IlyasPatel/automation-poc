Meta:
@tag feature:Job Application
@issue ODT0221-12085

Narrative:
As a existing jobseeker
I would like to apply for jobs
So I can earn more money

Scenario: From the SRP, apply for an external job without login in (AllowExternalAppsWithoutLogin).

Given I want to apply for a specific job
And the job is external
Then I am shown a redirect page and taken to site <externalSiteUrl> as this is an external job that does not require login

Examples:
|externalSiteUrl|
|https://www.google.co.uk/|
### About

Small personal project for friends Plumb Bristol business. You can browse previously completed project and bookmark. There is an Discovery tab to give you more ideas for your bathroom. You can also visit Team tab and get to know them

### Tech stack

Using fully compose and following MVVM pattern with Clean architecture principals. There are set of standard tools such as Compose, Hilt, Room, Retrofit and Firebase tools.

Firebase is used for backend, we use Firestore to store some of the data. Discovery tab is using Flickr API to get some inspirational ideas.

### Setup

Before running the project please create gradle.properties file at the :app level and populate
it with the following values. Keys will be provided on request

**flickrApiKey**-*ADD_YOUR_KEY_HERE*

Reason is that its not recommended to submit API keys to the source control due to security reasons.

### Improvements

* Looking to apply modularisation in the future, where it would have the following visability and practises :feature -> :domain <- :data
* Enhance details few with components and materials used, so uses can have a rough idea of the price. And will also be able to browse component
* Login and profile (currently its mocked locally), We will use Firebase auth for that
* Booking screen where users can make a requests for an estimation and fitter visit.

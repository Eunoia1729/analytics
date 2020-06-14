# elimu.ai Analytics 📊

Android application which collects and uploads learning data.

## Software Architecture

[
  <img width="320" alt="Software Architecture" src="https://user-images.githubusercontent.com/15718174/83595568-fb6a1e00-a594-11ea-990a-10c0bd62ed11.png">
](https://github.com/elimu-ai/wiki/blob/master/SOFTWARE_ARCHITECTURE.md)

## Learning Events

The various types of _Learning Events_ are handled by the Android receivers at [app/src/main/java/ai/elimu/analytics/receiver](app/src/main/java/ai/elimu/analytics/receiver).

  * StoryBookLearningEvent
  * WordLearningEvent
  * LetterLearningEvent

## Assessment Events

The various types of _Assessment Events_ are handled by the Android receivers at [app/src/main/java/ai/elimu/analytics/receiver](app/src/main/java/ai/elimu/analytics/receiver).

  * WordAssessmentEvent
  * LetterAssessmentEvent

## Usage Sample

```java
// Report WordLearningEvent to the Analytics application
Intent broadcastIntent = new Intent();
broadcastIntent.setPackage(BuildConfig.ANALYTICS_APPLICATION_ID);
broadcastIntent.setAction("ai.elimu.intent.action.WORD_LEARNING_EVENT");
broadcastIntent.putExtra("packageName", BuildConfig.APPLICATION_ID);
broadcastIntent.putExtra("wordText", wordText);
broadcastIntent.putExtra("learningEventType", "WORD_PRESSED");
sendBroadcast(broadcastIntent);
```

For an example of an app that is reporting learning events, see https://github.com/elimu-ai/vitabu.

---

## About the elimu.ai Community

![elimu ai-tagline](https://user-images.githubusercontent.com/15718174/54360503-e8e88980-465c-11e9-9792-32b513105cf3.png)

 * For a high-level description of the project, see https://github.com/elimu-ai/wiki/blob/master/README.md.
 * For project milestones, see https://github.com/elimu-ai/wiki/projects.

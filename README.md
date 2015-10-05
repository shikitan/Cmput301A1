
    App name: Dshin-Reflex
    Copyright 2015 Daniel Shin dshin@ualberta.ca

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

For more on the License, check the LICENSE document in the same directory.

# Cmput301A1 Dshin-Reflex By Daniel Shin

Video Demonstration URL: https://www.youtube.com/watch?v=DW7EioKkjWk&feature=youtu.be
Credit:
    In the making of this code:
        -I have referenced lonelyTwitter by Joshua Campbell
        -Discussed ideas with peers: Justin Wong and Spencer Plant
        -Used references on the developer.android.com page for:
            -CountDownTimer: http://developer.android.com/reference/android/os/CountDownTimer.html
            -Storage Options: http://developer.android.com/guide/topics/data/data-storage.html#pref
            -SharedPreferences: http://developer.android.com/reference/android/content/SharedPreferences.Editor.html
            -Email: https://developer.android.com/guide/components/intents-common.html#Email
        -Referred to some youtube tutorials on:
            -Android Tab Layout Tutorial by Son Pham: https://www.youtube.com/watch?v=cZ3yRY8jkHQ
            -Student Picker Saga by Abram Hindle
            -Using Alert Dialogs - By John Tapley:
                https://www.youtube.com/watch?v=XyFsUGEaaio&feature=iv&src_vid=OThGkyHlDlE&annotation_id=annotation_3947654907
        -Added Gson: http://www.techrepublic.com/blog/software-engineer/use-gson-to-work-with-json-in-your-android-apps/

This app is an attempt to create an app with two modes:
    1) Reactionn Time mode - which used a CountDownTimer class and ReactionManage/ReactionTime classes to attempt to record
        reactions times of the user. Stats were not recorded properly as there was an error with a NullPointer that
        I could not fix.
    2) Buzzer App which used SharedPreferences to save a counter for wins of each player. The stats for this were retainable
        and were persistent and could be cleared.

    There is a statistics page also where one can access their progress or delete it and also an email activity which would email
    the statistics to the given email with a client.

    There is an UML diagram the doc directory and an unsigned apk file within the bin directory.

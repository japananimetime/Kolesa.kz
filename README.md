# Kolesa.kz
MainActivity contains news without categorizing.
Categories are hold in the navigation drawer on the left.
Every category has an Activity, all of the are based on ListView.
Each contains 20 news that are requested through the API.
JsonGet requests 20  news belonging to specified during the request category through the API, gets title, date, source and description
Date is formatted and toString() method is used to form the array that is displayed on the activities. Items in array are Spanned and can be formatted with HTML tags.
App checks if it is offline in the onCreate() method.
Source is opened in the browser on the tap, link is found as a substring of the Item of the list that was tapped beginning from the result of lastIndexOf("http") method till the end of the string.
Made in the currently latest Android Studio, minimal API is 10, tested on Doogee DG700, Android 4.4.2, API 19, mtk6582
My first program for Android, so there can be strange things.

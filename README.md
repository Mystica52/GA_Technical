# App Description
This app is come to help to record the data of farmers corresponding to the crops they dig in session


# Architecture Summary
com.example.mykotlinapp/
data/
Farmer.kt : 			Entity (data class for Farmer)
   	FarmerDao.kt  : 		DAO interface for DB operations
   	AppDatabase.kt  :  		Room database singleton
 	FarmersViewModel.kt  : 	ViewModel with LiveData + insert method

 ui/
MainActivity.kt : Screen to enter farmer data
addFarmersActivity.kt   : 	Screen to insert farmers's data da list
FarmersListActivity.kt   : 	Screen to display all farmers in a list
FarmerAdapter.kt         : 	RecyclerView Adapter to display farmers list

res/
layout/
recordfarmer.xml         :  	Layout for MainActivity (input form)
activity_farmers_list.xml : 	Layout for FarmersListActivity (list)
item_farmer_row.xml       : 	RecyclerView row layout for farmer

values/
Colors.xml
Strings.xml
styles.xml

manifest/
AndroidManifest.xml
add also  `<activity android:name=".AddFarmerActivity"/>`

# Future Sync Strategy
1. Track Unsynced Data Locally
2. Create a Sync Service/Worker
3. Push Unsynced Farmers to the Server
4. Mark Records as Synced
5.  Pull Data from Server
6.  Add timestamps
7.  merge it if needed
8. detect when internet is avaialbe before synchronize automatically 

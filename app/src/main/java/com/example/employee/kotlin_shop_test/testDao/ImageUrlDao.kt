package com.example.employee.kotlin_shop_test.testDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import io.reactivex.Flowable


@Dao
public interface ImageUrlDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertImage(vararg users: ImageUrl)

    @Query("select * from Image where recordId =:id")
     fun getImageUrl(id: Int): ImageUrl
}
/*
 * Copyright 2018 Stefan Schüller <sschueller@techdroid.com>
 *
 * License: GPL-3.0+
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package net.schueller.peertube.network;

import net.schueller.peertube.model.Video;
import net.schueller.peertube.model.VideoList;

import java.util.Set;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetVideoDataService {
    @GET("videos/")
    Call<VideoList> getVideosData(
            @Query("start") int start,
            @Query("count") int count,
            @Query("sort") String sort,
            @Query("nsfw") String nsfw,
            @Query("filter") String filter,
            @Query("languageOneOf") Set<String> languages
    );

    @GET("videos/{id}")
    Call<Video> getVideoData(
            @Path(value = "id", encoded = true) String id
    );

    @GET("search/videos/")
    Call<VideoList> searchVideosData(
            @Query("start") int start,
            @Query("count") int count,
            @Query("sort") String sort,
            @Query("nsfw") String nsfw,
            @Query("search") String search,
            @Query("filter") String filter,
            @Query("languageOneOf") Set<String> languages
    );
}
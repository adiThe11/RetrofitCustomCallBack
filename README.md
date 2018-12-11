# RetrofitCustomCallBack
This is a custom CallBack for retrofit.


Needed graddle dependences : 

    implementation 'com.squareup.retrofit2:retrofit:2.3.0'
    implementation 'com.google.code.gson:gson:2.8.1'
    implementation 'com.squareup.retrofit2:converter-gson:2.3.0'


USE:

            call.enqueue(new CustomCallBack<T>(Activity.this) {
                        @Override
                        public void onResponse(Call<T> call, Response<T> response) {
                            super.onResponse(call , response);
                        }

                        @Override
                        public void onFailure(Call<T> call, Throwable t) {
                            super.onFailure(call , t);
                        }

             });

# RetrofitCustomCallBack
This is a custom CallBack for retrofit.


USE:

            call.enqueue(new CustomCallBack<T>(Activity.this) {
                        @Override
                        public void onResponse(Call<T> call, Response<T> response) {
                            super.onResponse(call , response);
                        }

                        @Override
                        public void onFailure(Call<HashMap> call, Throwable t) {
                            super.onFailure(call , t);
                        }

             });

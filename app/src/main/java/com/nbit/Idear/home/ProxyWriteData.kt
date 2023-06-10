package com.nbit.Idear.home

data class ProxyWriteData(val year:Int,
                          val month:Int,
                          val day:Int,
                          val content:String,
                          val additionalContent:ArrayList<WriteSubData>)
                          //val phoneNumArray:ArrayList<WriteSubData>)

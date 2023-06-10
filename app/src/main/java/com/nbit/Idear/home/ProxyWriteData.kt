package com.nbit.Idear.home


data class ProxyWriteData(
                        val image:Int,
                        val year:Int,
                          val month:Int,
                          val day:Int,
                          val title:String,
                          val content:String,
                          val additionalContent:ArrayList<WriteSubData>?)
                          //val phoneNumArray:ArrayList<WriteSubData>)


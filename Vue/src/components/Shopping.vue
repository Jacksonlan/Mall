<template>
    <div class="flex">
        <div class="ShoppingMessage" v-show="s.goods.length>0">
            <h1>购物车商品</h1>
            <!-- 顶部商品标题 -->
            <div class="leader_title">
                <li class="detail">商品信息</li>
                <li class="f1_center">规格</li>
                <li class="f1_center">单价</li>
                <li class="half">数量</li>
                <li class="f1_center">总价</li>
                <li class="f1_center">操作</li>   
            </div>
            <!-- 商品详情信息 -->
            <div class="goods_detail" v-for="(good,index) in s.goods">
                <li class="check"><input type="checkbox" v-model="good.select" @click="Sum(index)" /></li>
                <li class="pics"><img :src="'https://picture.jacksonlan.top/pictures/'+good.picture" class="img" alt="图片加载失败" /></li>
                <li class="goods_introduce">{{ good.introduce }}</li>
                <li class="f1_center">{{ good.current_load }}</li>
                <li class="f1_center">￥{{ parseFloat(good.current_price).toFixed(2) }}</li>
                <li class="half">
                    <input type="button" class="bu" value="-" @click="su(index)"/>
                    <input type="text" class="sl"  :value="good.current_count" readonly />
                    <input type="button" class="bu" value="+" @click="ad(index)" />
                    <p v-if="good.stock>=good.current_count" class="enough">有货</p>
                    <p v-else>暂无货物</p>
                </li>
                <li class="f1_center">￥{{(good.current_price * good.current_count).toFixed(2) }}</li>
                <li class="f1_center"><a href="javascript:;" @click="remove(good.sid)">移除购物车</a></li>
            </div>
            <!-- 底部结算栏 -->
            <div class="bottom_cal">
                <li class="all"><input type="checkbox" class="selectall" v-model="isChecked"/>全选</li>
                <div class="Total">
                <li>已选择<span class="number">{{ s.goods.filter(g=>g.select==true).length }}</span>件商品</li> 
                <li class="sum">总计:<span class="number">￥{{ Sum() }}</span></li>
                <li class="settlement"><button class="cal">去结算</button> </li>
                </div>
            </div>
        </div>
        <div class="isNull" v-show="s.goods.length===0">
            <img src="https://picture.jacksonlan.top/pictures/null.png" />
            <h1>您的购物车是空的!</h1>
        </div>
    </div>
</template>
<style src="@/assets/css/Shopping.css" scoped></style>
<script setup>
import store from "@/Store"
import { computed, onMounted } from "vue";
import api from '@/util/request.js'
import {useRouter} from 'vue-router'

const s=store.state.Shopping
const route=useRouter()

onMounted(()=>{
    store.commit("Shopping/GetCar")
})

const isChecked=computed({
    set:function(val){
        s.goods.forEach(g => {
            g.select=val
        });
    },
    get:function(){
       return s.goods.every(g=>g.select)
    }
})

const su=(i)=>{
    store.commit("Shopping/su",i)
}
const ad=(i)=>{
    store.commit("Shopping/ad",i)
}
const Sum=()=>{
    const deal=s.goods.filter(g=>g.select)
    s.sum=deal.reduce((acc,deal)=>{
    return acc+(deal.current_price * deal.current_count);
},0);
   return parseFloat(s.sum).toFixed(2)
}
const remove=(sid)=>{
    let url="/removeCar"
    let params={sid:sid}
    api.get(url,params).then(res=>{
        if(res.data.code===200){
            alert("商品已被移出购物车!")
            route.go(0)
        }
    })
}
</script>
<template>
    <!-- 背景滤镜 -->
<div class="BackFilter" v-if="a.IsShow">
    <!-- 弹窗窗体 -->
    <div class="ModelBody">
        <!-- 弹窗标题 -->
        <div class="ModelTitle">
            <h3>{{a.title}}</h3>
        </div>
        <!-- 弹窗内容 -->
        <div class="ModelContent">
            <input type="text" class="content" v-for="(t,i) in a.InputTitle" :placeholder="t.title" v-model="a.data[i]" />
            <select class="content" id="select" v-model="a.other">
                <option value="无" selected>无</option>
                <option value="公司">公司</option>
                <option value="家">家</option>
            </select>
            <!-- 弹窗底部按钮 -->
            <div class="ModelBottom">
                <button class="button r3" @click="Submit" v-show="a.title==='添加收货地址'">提交</button>
                <button class="button r3" @click="EditSubmit" v-show="a.title==='编辑'">确认</button>
                <button class="button" @click="Cancel">取消</button>
            </div>
        </div>
    </div>
</div>
</template>
<style src="@/assets/css/Alert.css" scoped />
<script setup>
import { useStore } from 'vuex';
import {useRouter} from 'vue-router'
import api from '@/util/request.js'

const store=useStore()
const router=useRouter()
const a=store.state.Alert
const ad=store.state.Address

const Cancel=()=>{
    store.commit("Alert/Clear")
    store.commit("Alert/SwitchAlert")
}
const Submit=()=>{
    if(a.data.length===a.InputTitle.length){
        let url="/addAddress"
        let data={
            address_id:ad.data.length+1,
            uid:sessionStorage.getItem("uid"),
            get_people:a.data[0],
            area:a.data[1],
            detail:a.data[2],
            phone:a.data[3],
            other:a.other
        }
        api.post(url,data).then(res=>{
            if(res.data.code===200){
                ad.submit='提交'
                console.log(ad.submit);
                router.go(0)
                alert("添加地址成功!")
                Cancel()
            }
        })
    }else{
        alert("您有数据未输入,请补充!")
    }
}
const EditSubmit=()=>{
        let url="/updateAddress"
        let data={
            "get_people":a.data[0],
            "phone":a.data[3],
            "area":a.data[1],
            "detail":a.data[2],
            "other":a.other,
            "address_id":a.data[4]
        }
        api.post(url,data).then(res=>{
            if(res.data.code===200){
                console.log(res.data.data);
                router.go(0)
                alert("修改地址成功!")
                store.commit("Alert/SwitchAlert")
            }else{
                alert("修改地址失败!")
            }
        })
    }
</script>

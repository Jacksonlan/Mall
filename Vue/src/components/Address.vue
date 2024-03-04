<template>
    <!-- 最外层盒子 -->
    <div class="Address">
        <h1>收货地址</h1>
        <!-- 收货地址操作栏 -->
        <div class="AddressAction">
        <button class="newAddress" @click="AddSite">添加收货地址</button>
        <span class="CountQuilty" v-show="ads.data.length!==0">您已有{{ ads.data.length }}个收货地址</span>
        <span class="currentAddress" v-show="ads.data.length!==0">当前地址为:{{ ads.DefaultAddress }}</span>
        </div>
        <!-- 引入弹窗组件 -->
        <Alert v-show="alt.IsShow" />
        <!-- 当没有收货地址时 -->
        <div class="Null" v-show="ads.data.length===0">
            <h1>很抱歉,您还没有收货地址!</h1>
        </div>
        <!-- 收货地址信息展示栏 -->
        <div class="AddressMessage" v-for="(d,i) in ads.data">
            <div class="Spical">
            <h4>{{ d.other }}</h4> <span class="InitAddress" v-show="ads.IsDefault==d.address_id">默认地址</span>
            </div>
            <span class="notice">收货人昵称：{{ d.get_people }}</span>
            <span class="notice">地址信息：{{ d.area }}</span>
            <span class="notice">详细地址：{{ d.detail }}</span>
            <span class="notice">手机号码：{{ d.phone }}</span>
            <div class="Edi">
                <a href="javascript:;" class="SetInit" v-show="ads.IsDefault!=d.address_id" @click="SetDefault(d.address_id)">设为默认地址</a>
                <a href="javascript:;" class="edit" @click="edit(i)">编辑</a>
                <a href="javascript:;" class="edit" @click="DeleteAddress(d.address_id,i)">删除地址</a>
            </div>
        </div>
    </div>
</template>
<style src="@/assets/css/Address.css" scoped />
<script setup>
import { onMounted } from 'vue';
import Alert from '@/components/Alert.vue';
import {useRouter} from 'vue-router'
import {useStore} from 'vuex'
import api from "@/util/request.js"

const store=useStore()
const router=useRouter()
const ads=store.state.Address
const alt=store.state.Alert

onMounted(()=>{
    store.commit("Address/GetData")
    store.commit("Address/GetDefaultAddress")
})

const SetDefault=(aid)=>{
    store.commit("Address/SetDefault",aid)
}

const DeleteAddress=(id,i)=>{
    const url="/deleteAddress"
    const params={address_id:id}
    api.get(url,params).then(res=>{
        if(res.data.code===200){
            if(sessionStorage.getItem("aid")==i){
                UpdateDefaultAddress(0)
                sessionStorage.removeItem("default")
                sessionStorage.removeItem("aid")
            }
            alert("删除地址成功!")
            router.go(0)
        }else{
            alert("删除地址失败!")
        }
    })
}

const AddSite=()=>{
    store.commit("Alert/SwitchAlert","添加收货地址")
}

const edit=(i)=>{
    store.commit("Alert/SwitchAlert","编辑")
    alt.data[0]=ads.data[i].get_people
    alt.data[1]=ads.data[i].area
    alt.data[2]=ads.data[i].detail
    alt.data[3]=ads.data[i].phone
    alt.other=ads.data[i].other
    alt.data[4]=ads.data[i].address_id
}
</script>
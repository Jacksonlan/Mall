import {createStore} from 'vuex'
import Right from './modules/Right'
import Top from './modules/Top'
import Login from './modules/Login'
import Address from './modules/Address'
import Alert from './modules/Alert'
import Register from './modules/Register'
import Bottom from './modules/Bottom'
import Order from './modules/Order'
import Goods_home from './modules/Goods_home'
import Detail from './modules/Detail'
import Comment from './modules/Comment'
import Shopping from './modules/Shopping'

export default createStore({
    // 定义参数
    state:{},
    // 相当于vue中的computed计算函数 只能读取不能修改数据
    getters:{},
    // vuex中定义函数方法
    mutations:{},
    // 异步数据处理 通过actions异步获取参数在mutations中执行函数
    actions:{},
    // 获取模块
    modules:{
        Right,
        Top,
        Login,
        Address,
        Alert,
        Register,
        Bottom,
        Order,
        Goods_home,
        Detail,
        Comment,
        Shopping
    }
})
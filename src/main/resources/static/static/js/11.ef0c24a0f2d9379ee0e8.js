webpackJsonp([11],{JKGe:function(t,e){},fSNo:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i=s("CaOM"),a={data:function(){return{input:"",select:"",startT:"",endT:"",input1:"",select1:"",startT1:"",endT1:"",ApplyLoading:!1,RecordLoading:!1,userHistoryList:[],userApplyList:[],applyTotal:0,historyTotal:0,applyList:{startTime:"",endTime:"",page:1,rowNum:10},applyListHistory:{startTime:"",endTime:"",page:1,rowNum:10},id:"",historyList:{page:1,rowNum:"10"}}},methods:{getApplyList:function(){var t=this;if(""!=this.select&&(this.applyList[this.select]=this.input),""!=this.applyList.startTime){var e=Object(i.b)(this.applyList.startTime);this.startT=Object(i.c)(e)}if(""!=this.applyList.endTime){var s=Object(i.b)(this.applyList.endTime);this.endT=Object(i.c)(s)}this.ApplyLoading=!0;var a={page:this.applyList.page,rowNum:this.applyList.rowNum,uid:"",phoneNumber:"",startTime:this.startT,endTime:this.endT};"uid"==this.select?a.uid=this.input:"phoneNumber"==this.select&&(a.phoneNumber=this.input),Object(i.a)(this,this.ApiConfig.userManagement.queryApplyInfo,a,function(e){if(200!=e.code)return t.$notify({title:"提示",message:e.message,type:"warning"}),!1;t.userApplyList=e.data.rows,t.applyTotal=e.data.total,t.userApplyList.forEach(function(e,s,a){t.userApplyList[s].changeType=2==t.userApplyList[s].changeType?"邮箱":"手机",t.userApplyList[s].ctime=Object(i.d)("Y-M-D h:m:s",a[s].ctime)}),t.startT="",t.endT="",t.ApplyLoading=!1},"POST")},handleApply:function(t,e){1===e?(this.applyList.page=t,this.getApplyList()):(this.applyListHistory.page=t,this.getApplyHistory())},approveApply:function(t,e){var s=this,a={id:e.id};Object(i.a)(this,this.ApiConfig.userManagement.approveApply,a,function(t){if(200!=t.code)return s.$notify.error({title:"错误",message:t.message}),!1;s.getApplyList(),s.getApplyHistory(),s.$notify({title:"成功",message:t.message,type:"success"})},"POST")},open2:function(t,e){var s=this;this.$confirm("此操作将通过用的申请, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){s.$message({type:"success",message:"通过申请!"}),s.approveApply(t,e)}).catch(function(){s.$message({type:"info",message:"拒绝申请"})})},rejectApply:function(t,e){var s=this,a={id:e.id};Object(i.a)(this,this.ApiConfig.userManagement.rejectApply,a,function(t){if(200!=t.code)return s.$notify.error({title:"错误",message:t.message}),!1;s.getApplyList(),s.getApplyHistory(),s.$notify({title:"成功",message:t.message,type:"success"})},"POST")},open3:function(t,e){var s=this;this.$confirm("此操作将拒绝用户修改信息, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){s.$message({type:"success",message:"拒绝修改!"}),s.rejectApply(t,e)}).catch(function(){s.$message({type:"info",message:"没有操作"})})},getApplyHistory:function(){var t=this;if(""!=this.select1&&(this.applyListHistory[this.select1]=this.input1),""!=this.applyListHistory.startTime){var e=Object(i.b)(this.applyListHistory.startTime);this.startT1=Object(i.c)(e)}if(""!=this.applyListHistory.endTime){var s=Object(i.b)(this.applyListHistory.endTime);this.endT1=Object(i.c)(s)}var a={page:this.applyListHistory.page,rowNum:this.applyListHistory.rowNum,uid:"",phoneNumber:"",startTime:this.startT1,endTime:this.endT1};"uid"==this.select1?a.uid=this.input1:"phoneNumber"==this.select1&&(a.phoneNumber=this.input1),console.log("修改记录:",a),Object(i.a)(this,this.ApiConfig.userManagement.queryApplyHistory,a,function(e){t.userHistoryList=e.data.rows,t.historyTotal=e.data.total,t.userHistoryList.forEach(function(e,s,a){t.userHistoryList[s].changeType=2==t.userHistoryList[s].changeType?"邮箱":"手机",t.userHistoryList[s].applyStatus=1==t.userHistoryList[s].applyStatus?"待审核":2==t.userHistoryList[s].applyStatus?"已通过":"已拒绝",t.userHistoryList[s].ctime=Object(i.d)("Y-M-D h:m:s",a[s].ctime)}),t.startT1="",t.endT1=""},"POST")},handleReset:function(){this.$refs.applyList.resetFields(),this.applyList.startTime="",this.applyList.endTime="",this.applyList.page="1",this.applyList.rowNum="10",this.select="",this.input="",this.getApplyList()},handleReset1:function(){this.$refs.applyListHistory.resetFields(),this.applyListHistory.startTime="",this.applyListHistory.endTime="",this.applyListHistory.page="1",this.applyListHistory.rowNum="10",this.select1="",this.input1="",this.getApplyHistory()},tableRowClassName:function(t){t.row;if(t.rowIndex%2==1)return"success-row"}},mounted:function(){this.getApplyList(),this.getApplyHistory()}},l={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{attrs:{id:"apply"}},[s("section",[s("span",{staticClass:"title"},[t._v(t._s(t.$t("modification.modification")))]),t._v(" "),s("el-col",{staticClass:"toolbar",staticStyle:{"padding-bottom":"0px"},attrs:{span:24}},[s("el-form",{ref:"applyList",attrs:{inline:!0,model:t.applyList}},[s("el-form-item",{attrs:{label:t.$t("userList.register[0]")}},[s("el-date-picker",{attrs:{type:"date",placeholder:t.$t("userList.register[1]")},model:{value:t.applyList.startTime,callback:function(e){t.$set(t.applyList,"startTime",e)},expression:"applyList.startTime"}})],1),t._v(" "),s("el-form-item",{attrs:{label:t.$t("userList.register[2]")}},[s("el-date-picker",{attrs:{type:"date",placeholder:t.$t("userList.register[3]")},model:{value:t.applyList.endTime,callback:function(e){t.$set(t.applyList,"endTime",e)},expression:"applyList.endTime"}})],1),t._v(" "),s("el-form-item",[s("el-input",{staticClass:"input-with-select",attrs:{placeholder:t.$t("pleaseEnter")},model:{value:t.input,callback:function(e){t.input=e},expression:"input"}},[s("el-select",{attrs:{slot:"prepend",placeholder:t.$t("Pchoose")},slot:"prepend",model:{value:t.select,callback:function(e){t.select=e},expression:"select"}},[s("el-option",{attrs:{label:"UID",value:"uid"}})],1)],1)],1),t._v(" "),s("el-form-item",[s("el-button",{staticClass:"warning",on:{click:t.getApplyList}},[t._v(t._s(t.$t("userList.register[5]")))])],1),t._v(" "),s("el-form-item",[s("el-button",{staticClass:"info",on:{click:t.handleReset}},[t._v(t._s(t.$t("userList.register[6]")))])],1)],1)],1),t._v(" "),s("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.ApplyLoading,expression:"ApplyLoading"}],staticStyle:{width:"100%"},attrs:{data:t.userApplyList,"row-class-name":t.tableRowClassName}},[s("el-table-column",{attrs:{prop:"id",label:t.$t("modification.tableHead[0]"),width:"175"}}),t._v(" "),s("el-table-column",{attrs:{prop:"uid",label:t.$t("modification.tableHead[1]"),width:"175"}}),t._v(" "),s("el-table-column",{attrs:{prop:"changeType",label:t.$t("modification.tableHead[2]")}}),t._v(" "),s("el-table-column",{attrs:{prop:"oldInfo",label:t.$t("modification.tableHead[3]"),width:"275"}}),t._v(" "),s("el-table-column",{attrs:{prop:"newInfo",label:t.$t("modification.tableHead[4]"),width:"275"}}),t._v(" "),s("el-table-column",{attrs:{prop:"ctime",label:t.$t("modification.tableHead[6]"),width:"260"}}),t._v(" "),s("el-table-column",{attrs:{label:t.$t("modification.tableHead[7]"),width:"160"},scopedSlots:t._u([{key:"default",fn:function(e){return[s("el-button",{attrs:{size:"mini",calss:"tableBtn"},on:{click:function(s){t.open2(e.$index,e.row)}}},[t._v(t._s(t.$t("pass")))]),t._v(" "),s("el-button",{attrs:{size:"mini"},on:{click:function(s){t.open3(e.$index,e.row)}}},[t._v(t._s(t.$t("refuse")))])]}}])})],1),t._v(" "),s("div",{directives:[{name:"show",rawName:"v-show",value:t.applyTotal>10,expression:"applyTotal>10"}],staticClass:"page"},[s("el-col",{staticClass:"toolbar  ",attrs:{span:24}},[s("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:t.applyTotal},on:{"current-change":function(e){t.handleApply(1)}}})],1)],1)],1),t._v(" "),s("section",[s("span",{staticClass:"title"},[t._v(t._s(t.$t("modification. record")))]),t._v(" "),s("el-col",{staticClass:"toolbar",staticStyle:{"padding-bottom":"0px"},attrs:{span:24}},[s("el-form",{ref:"applyListHistory",attrs:{inline:!0,model:t.applyListHistory}},[s("el-form-item",{attrs:{label:t.$t("userList.register[0]")}},[s("el-date-picker",{attrs:{type:"date",placeholder:t.$t("userList.register[1]")},model:{value:t.applyListHistory.startTime,callback:function(e){t.$set(t.applyListHistory,"startTime",e)},expression:"applyListHistory.startTime"}})],1),t._v(" "),s("el-form-item",{attrs:{label:t.$t("userList.register[2]")}},[s("el-date-picker",{attrs:{type:"date",placeholder:t.$t("userList.register[3]")},model:{value:t.applyListHistory.endTime,callback:function(e){t.$set(t.applyListHistory,"endTime",e)},expression:"applyListHistory.endTime"}})],1),t._v(" "),s("el-form-item",[s("el-input",{staticClass:"input-with-select",attrs:{placeholder:t.$t("pleaseEnter")},model:{value:t.input1,callback:function(e){t.input1=e},expression:"input1"}},[s("el-select",{attrs:{slot:"prepend",placeholder:t.$t("Pchoose")},slot:"prepend",model:{value:t.select1,callback:function(e){t.select1=e},expression:"select1"}},[s("el-option",{attrs:{label:"UID",value:"uid"}})],1)],1)],1),t._v(" "),s("el-form-item",[s("el-button",{staticClass:"warning",on:{click:t.getApplyHistory}},[t._v(t._s(t.$t("userList.register[5]")))])],1),t._v(" "),s("el-form-item",[s("el-button",{staticClass:"info",on:{click:t.handleReset1}},[t._v(t._s(t.$t("userList.register[6]")))])],1)],1)],1),t._v(" "),s("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.RecordLoading,expression:"RecordLoading"}],staticStyle:{width:"100%"},attrs:{data:t.userHistoryList,"row-class-name":t.tableRowClassName}},[s("el-table-column",{attrs:{prop:"id",label:t.$t("modification.tableHead[0]"),width:"175"}}),t._v(" "),s("el-table-column",{attrs:{prop:"uid",label:t.$t("modification.tableHead[1]"),width:"175"}}),t._v(" "),s("el-table-column",{attrs:{prop:"changeType",label:t.$t("modification.tableHead[2]")}}),t._v(" "),s("el-table-column",{attrs:{prop:"oldInfo",label:t.$t("modification.tableHead[3]")}}),t._v(" "),s("el-table-column",{attrs:{prop:"newInfo",label:t.$t("modification.tableHead[4]")}}),t._v(" "),s("el-table-column",{attrs:{prop:"ctime",label:t.$t("modification.tableHead[6]")}}),t._v(" "),s("el-table-column",{attrs:{prop:"applyStatus",label:t.$t("modification.tableHead[7]")}})],1),t._v(" "),s("div",{directives:[{name:"show",rawName:"v-show",value:t.historyTotal>10,expression:"historyTotal>10"}],staticClass:"page"},[s("el-col",{staticClass:"toolbar  ",attrs:{span:24}},[s("el-pagination",{attrs:{background:"",layout:"prev, pager, next",total:t.historyTotal},on:{"current-change":t.handleApply}})],1)],1)],1)])},staticRenderFns:[]};var o=s("VU/8")(a,l,!1,function(t){s("JKGe"),s("oArq")},"data-v-24a98fde",null);e.default=o.exports},oArq:function(t,e){}});
//# sourceMappingURL=11.ef0c24a0f2d9379ee0e8.js.map
webpackJsonp([17],{"58bt":function(e,t){},"6xlC":function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l=o("CaOM"),a={data:function(){return{goldForm:{gFee:"",kgFee:""}}},methods:{showGoldDrawFee:function(){var e=this;Object(l.a)(this,this.ApiConfig.feeConfigure.showGoldDrawFee,{},function(t){if(console.log(t),200!=t.code)return e.$notify({title:"提示",message:t.message,type:"warning"}),!1;e.goldForm.gFee=t.data.G100g,e.goldForm.kgFee=t.data.G1000g},"POST")},setGoldDrawFee:function(e,t){var o=this,a={type:e,fee:t};Object(l.a)(this,this.ApiConfig.feeConfigure.setGoldDrawFee,a,function(e){return console.log(e),200==e.code?(o.$notify({title:"提示",message:e.message,type:"success"}),!1):(o.$notify({title:"提示",message:e.message,type:"warning"}),!1)},"POST")}},mounted:function(){this.showGoldDrawFee()}},s={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{attrs:{id:"gradeFee"}},[o("span",{staticClass:"title"},[e._v(e._s(e.$t("GoldWithdrawalFee")))]),e._v(" "),o("el-col",{staticClass:"toolbar",staticStyle:{"padding-bottom":"0px"},attrs:{span:24}},[o("el-form",{attrs:{inline:!0,model:e.goldForm,"label-position":"left"}},[o("el-col",{staticClass:"toolbar",staticStyle:{"padding-bottom":"0px"},attrs:{span:24}},[o("el-form-item",{attrs:{label:"100g"+e.$t("GoldWithdrawalFee")}},[o("el-input",{attrs:{placeholder:e.$t("PleaseService")},model:{value:e.goldForm.gFee,callback:function(t){e.$set(e.goldForm,"gFee",t)},expression:"goldForm.gFee"}})],1),e._v(" "),o("el-form-item",[o("el-button",{attrs:{type:"warning"},on:{click:function(t){e.setGoldDrawFee(1,e.goldForm.gFee)}}},[e._v(e._s(e.$t("confirm")))])],1)],1),e._v(" "),o("el-col",{staticClass:"toolbar",staticStyle:{"padding-bottom":"0px"},attrs:{span:24}},[o("el-form-item",{attrs:{label:"1000g"+e.$t("GoldWithdrawalFee")}},[o("el-input",{attrs:{placeholder:e.$t("PleaseService")},model:{value:e.goldForm.kgFee,callback:function(t){e.$set(e.goldForm,"kgFee",t)},expression:"goldForm.kgFee"}})],1),e._v(" "),o("el-form-item",[o("el-button",{attrs:{type:"warning"},on:{click:function(t){e.setGoldDrawFee(2,e.goldForm.kgFee)}}},[e._v(e._s(e.$t("confirm")))])],1)],1)],1)],1)],1)},staticRenderFns:[]};var n=o("VU/8")(a,s,!1,function(e){o("58bt")},null,null);t.default=n.exports}});
//# sourceMappingURL=17.ff9246cac62ba0432c4f.js.map
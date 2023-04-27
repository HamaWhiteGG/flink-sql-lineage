import {observable, action, runInAction} from 'mobx'
import {message} from 'antd'
import _ from 'lodash'
// import io from '../io'

class Store {
  @observable curName = ''
  @observable curDescr = ''
  @observable curType = ''
  @observable curClassId = ''
  @observable curNodeId =''
  @observable curNodeTableIcon = ''
  @observable infoData = []
  @observable isInfoContentOpen = false
  @observable isDetectLoopOpen = false
  @observable isUnfoldAll = false
  @observable loopData = {nodes: [], links: []}
  @observable refreshFlag = 0
  @observable curScale = 1
  @observable focusFlag = 0

  // 是否聚焦
  @action focusLineage() {
    console.log(9999)
    this.focusFlag++
  }

  // 放大
  @action plusScale() {
    if (this.curScale < 5) {
      this.curScale += 0.25
    }
    console.log(this.curScale)
  }

  // 缩小
  @action reduceScale() {
    if (this.curScale > 0.25) {
      this.curScale -= 0.25
    }
    console.log(this.curScale)
  }

  @action.bound async getInfoData(params) {
    // try {
    //   const res = await io.getNodeDetails(params)
    //   runInAction(() => {
    //     this.infoData = res.relAttrList
    //   })
    // } catch (e) {
    //   message.error(e.message)
    // }
  }

  // 获取当前表或字段名称，类型，描述
  @action.bound getInitInfo(data) {
    console.log()
    const {name, descr, type, classId, id, tableIcon} = data
    this.curName = name
    this.curDescr = descr
    this.curType = type
    this.curClassId = classId
    this.curNodeId = id
    this.curNodeTableIcon = tableIcon
  }
  

  // 打开信息框
  @action.bound openInfoContent() {
    this.isInfoContentOpen = true
  }

  // 关闭信息框
  @action.bound closeInfoContent() {
    this.isInfoContentOpen = false
  }

  // 打开关闭环路检测
  @action.bound clickDetectLoop() {
    this.isDetectLoopOpen = !this.isDetectLoopOpen
  }

  @action.bound clickUnfoldAll() {
    this.isUnfoldAll = !this.isUnfoldAll
  }

  @action.bound changeLoopData(o, n) {
    this.isInfoContentOpen = false

    const oldData = _.cloneDeep(o)
    const newData = _.cloneDeep(n)

    const oldDataLinks = oldData.links
    const oldDataNodes = oldData.nodes

    const newDataNodesId = newData.nodes.map(t => t.id)
    const newDataLinksId = newData.links.map(t => t.id)

    const newDataLinks = oldDataLinks.length > 0 ? oldDataLinks.map(t => {
      if (newDataLinksId.includes(t.id)) {
        t.isLoopActive = true
      } else {
        t.isLoopActive = false
      }
      return t
    }) : newData.links.map(t => {
      t.isLoopActive = false
      return t
    })
    const newDataNodes = oldDataNodes.length > 0 ? oldDataNodes.map(t => {
      if (newDataNodesId.includes(t.id)) {
        t.isLoopActive = true
      } else {
        t.isLoopActive = false
      }
      return t
    }) : newData.nodes.map(t => {
      t.isLoopActive = false
      return t
    })

    const conLinks = oldDataLinks.concat(newDataLinks)
    const conNodes = oldDataNodes.concat(newDataNodes)

    const newLoopData = {
      links: _.uniqBy(conLinks, 'id'),
      nodes: _.uniqBy(conNodes, 'id'),
    }
    this.loopData = newLoopData

  }

  @action.bound refreshLineage() {
    this.refreshFlag++
    this.isInfoContentOpen = false
  }
}

// 默认导出接口
export const store = new Store()

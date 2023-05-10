import React,{ useState, useRef, useContext, useEffect } from 'react'
import { Form, Select, Typography } from 'antd'
import _ from 'lodash'
import {LineageTable} from '../component/react-lineage-dag'
import {getInit, getShrinkDownChildren, getShrinkUpChildren} from './utils'
import getOps from './component/operator/operator'
import { store } from './store'

const { Option } = Select
const { Text } = Typography
const Page = ({data, taskDetail, catalogList}) => {
  // console.log('catalogList---,', catalogList?.filter(t => t.catalogId === taskDetail?.catalogId)[0]?.catalogName)
  const [form] = Form.useForm()
  const cvsRef = useRef(null)
  const {getInfoData, getInitInfo, openInfoContent} = store
  const [relayout, setRelayout] = useState(false)
  const [focus, setFocus] = useState(false)
  const [linksMap, setLinksMap] = useState({})
  
  // console.log('data-----', data)
  console.log('血缘图节点数:', data.nodes.length, '; 关联线数:', data.links.length)
  
  const fetchData = async (params, cb) => {
    try {
      // const res = await io.getLineageNew(params)
      // if (res.links.length > 0) {
      //   cb(res)
      // } else {
      //   message.warning('没有更多数据了')
      // }
    } catch (error) {
      // errorEater(error.message)
    }
  }
  // 获取详情
  const fetchInfo = async (params, cb) => {
    // try {
    //   const res = await io.getNodeDetails(params)

    // } catch (error) {
    //   errorEater(error.message)
    // }
  }
  const renderNew = (oldData, resData) => {
    // 需要合并数据
    const oldLinks = oldData.links
    const oldNodes = oldData.nodes
    const resLinks = resData.links
    const resNodes = resData.nodes
    let newLinks = []
    let newNodes = []

    const conLinks = oldLinks.concat(resLinks)
    newLinks = _.uniqBy(conLinks, 'id')
    const conNodes = oldNodes.concat(resNodes)
    newNodes = _.uniqBy(conNodes, 'id')

    setData({
      links: newLinks,
      nodes: newNodes,
    })
  }

  const onAction = props => {
    const {action, tableId, classId, scopeType, level, type, descr, name, tableIcon} = props
    switch (action) {
      case 'expand': {
        const table = data.nodes.find(t => t.id === tableId)
        table.isExpand = true
        fetchData({
          id: tableId,
          scopeType, 
          level,
        }, res => {
          res.nodes = res.nodes.map(t => {
            t.id = `${t.id}`
            t.isFold = true
            t.scopeType = `${scopeType}`
            if (!t.columns) {
              t.columns = []
            }
            return t
          })
          const newRes = Object.assign({}, res)
          const taskObjBmp = {}
          res.links
          .forEach(t => {
            if (!t.u && !t.v) {
              taskObjBmp[`${t.relU}-${t.relV}`] = _.cloneDeep(t.task)
            }
          })
          newRes.links.forEach(t => {
            if (taskObjBmp[`${t.relU}-${t.relV}`]) {
              t.task = taskObjBmp[`${t.relU}-${t.relV}`]
            }
          })

          if (table.isFold) {
            // Unfold
          } else {
            // fold
            const arry = newRes.links.filter(t => (tableId === t.relU || tableId === t.relV) && !t.u && !t.v)
            const newArry = arry.filter(t => {
              const nodeType = newRes.nodes.find(node => node.id !== tableId && (node.id === t.relV || node.id === t.relU)).type
              return nodeType === 2
            })

            let obj = Object.assign({}, linksMap)
            obj[`${tableId}`] = arry
            setLinksMap(obj)

            // // 隐藏当前表直接上下游表血缘
            // newArry.forEach(a => {
            //   const index = newRes.links.findIndex(link => link.id === a.id)
            //   newRes.links.splice(index, 1)
            // })


            // 在上下游血缘中查找上下游节点是否为表，是，DownIsTable：true，否，DownIsTable：false
            arry.forEach(t => {
              const sourceNode = newRes.nodes.find(n => n.id === t.relU)
              const targetNode = newRes.nodes.find(n => n.id === t.relV)
              if (targetNode.type !== 2) {
                sourceNode.DownIsTable = false
                data.nodes.forEach(n => {
                  if (n.id === table.id) {
                    n.DownIsTable = sourceNode.DownIsTable
                  }
                })
              } else {
                sourceNode.DownIsTable = true
              }
            })
            newRes.links = newRes.links.concat(linksMap[`${tableId}`])
          }
          renderNew(data, newRes)

        })
        break
      }
      case 'shrink': {
        // scopeType为方向，1：上游，2:下游
        const newData = Object.assign({}, data)
        const table = data.nodes.find(t => t.id === tableId)
        table.isExpand = false
        const queue = []
        queue.unshift(table)
        let nodes = []
        let links = []
        while (queue.length !== 0) {
          // 顶点出队列
          const v = queue.shift()
          v.isExpand = false
          // 1:查找上游，2：查找下游
          if (scopeType === '1') {
            if (data.links.find(t => t.relV === v.id)) {
              // 获取顶点关联的所有边和点 childrenObj
              const childrenObj = getShrinkUpChildren(newData, v.id)
              if (childrenObj.nodes.length > 0) {
                childrenObj.nodes.forEach(t => {
                  // 所有顶点进队列
                  queue.unshift(t)
                })
              }
  
              nodes = nodes.concat(childrenObj.nodes)
              links = links.concat(childrenObj.links)
            }
          } else if (scopeType === '2') {
            // 顶点有血缘，执行查找
            if (data.links.find(t => t.relU === v.id)) {
              // 获取顶点关联的所有边和点 childrenObj
              const childrenObj = getShrinkDownChildren(newData, v.id)
              if (childrenObj.nodes.length > 0) {
                childrenObj.nodes.forEach(t => {
                  // 所有顶点进队列
                  queue.unshift(t)
                })
              }

              nodes = nodes.concat(childrenObj.nodes)
              links = links.concat(childrenObj.links)
            }
          }
        }

        nodes.forEach(t => {
          const index = data.nodes.findIndex(r => r.id === t.id)
          if (index > -1) {
            data.nodes.splice(index, 1)
          }
        })

        links.forEach((relation) => {
          const index = data.links.findIndex(r => r.id === relation.id)
          if (index > -1) {
            data.links.splice(index, 1)
          }
        })

        data.links.forEach((l, index)=> {
          const conNodes = nodes.find(t => t.id === l.relV)
          if (!!conNodes) {
            data.links.splice(index, 1)
          }
        })
        
        setData({...data})
        break
      }
      case 'fold': {
        // 当前折叠，点击展开
        // 查找当前表直接上下游表血缘
        const arry = data.links.filter(t => {
          return (tableId === t.relU || tableId === t.relV) && !t.u && !t.v
        })
        let obj = Object.assign({}, linksMap)
        const newArry = arry.filter(t => {
          const nodeType = data.nodes.find(node => node.id !== tableId && (node.id === t.relV || node.id === t.relU)).type || 2
          return nodeType === 2
        })
        obj[`${tableId}`] = newArry
        setLinksMap(obj)

        // 隐藏当前表直接上下游表血缘
        // newArry.forEach(a => {
        //  const index = data.links.findIndex(link => link.id === a.id)
        //  data.links.splice(index, 1)
        // })

        data.nodes.forEach(table => {
          if (table.id !== tableId) {
            return
          }
          table.isFold = false
        })

        // 在上下游血缘中查找上下游节点是否为表，是，DownIsTable：true，否，DownIsTable：false
        arry.forEach(t => {
          const sourceNode = data.nodes.find(n => n.id === t.relU)
          const targetNode = data.nodes.find(n => n.id === t.relV)
          if (targetNode.type !== 2) {
            sourceNode.DownIsTable = false
          } else {
            sourceNode.DownIsTable = true
          }
          data.nodes.forEach(n => {
            n = _.cloneDeep(sourceNode)
          })
        })
        data.nodes = [...data.nodes]
        setData({...data})
        break
      }
      case 'unfold': {
        // 当前展开，点击后折叠
        data.nodes.forEach(table => {
          if (table.id !== tableId) {
            return
          }

          table.isFold = true
        })
        // 获取当前表下游节点

        // 显示当前表直接上下游表血缘
        linksMap[`${tableId}`].forEach(t => {
          const nodesArry = data.nodes
            .filter(node => node.id !== tableId && (node.id === t.relU || node.id === t.relV))
            // .filter(node => node.id !== tableId)
          // 当上下游节点为收起状态：isFold = true时，添加表关系，否则不添加
          if(nodesArry[0]?.isFold) {
            data.links.splice(0, 0, t)
          }
        })

        data.nodes = [...data.nodes]
        setData({...data})
        break
      }
      case 'info': {
        // 打开信息框
        openInfoContent()
        getInfoData({
          id: tableId,
          type, 
          needDownstream: 0,
        })
        getInitInfo({
          name,
          descr,
          type,
          classId,
          id: tableId,
          tableIcon,
        })
        // store.curType = type
        // store.curClassId = classId
        // store.curNodeId = tableId
      }
      default:
        break
    }
  }

  data.nodes.forEach(table => {
    // 当前节点是否有下游
    const downIndex = data.links.findIndex(t => t.relU === table.id)
    const upIndex = data.links.findIndex(t => t.relV === table.id)
    table.isUpExpand = upIndex !== -1
    table.isDownExpand = downIndex !== -1
    table.operators = getOps({
      isUpExpand: upIndex !== -1,
      isDownExpand: downIndex !== -1,
      isExpand: table.isExpand,
      isFold: !!table.isFold,
      isPrimary: table.isPrimary,
      scopeType: table.scopeType, // 当前节点与主表的上下游关系
      onAction,
      tableId: table.id,
      classId: table.classId,
      type: table.type,
      name: table.name,
      descr: table.descr,
      loopNum: 0,
      hasDownstream: table.hasDownstream,
      hasUpstream: table.hasUpstream,
      tableIcon: table.tableIcon,
    })
  })

  // 展开全部字段，隐藏表血缘
  const hiddenTableLineage = () => {
    const arry = data.links.filter(t => {
      const sourceNode = _.cloneDeep(data.nodes.find(n => n.id === t.relU))
      const targetNode = data.nodes.find(n => n.id === t.relV)
      // sourceNode.DownIsTable = true

      if (targetNode.type !== 2) {
        sourceNode.DownIsTable = false
      } else {
        sourceNode.DownIsTable = true
      }
     
      return !sourceNode.DownIsTable && (!t.u && !t.v)
    })
    
    const obj = Object.assign({}, linksMap)
    data.nodes.forEach(node => {
      const tableId = node.id
      obj[tableId] = data.links.filter(t => {
        return (t.relU === tableId || t.relV === tableId)
      })
    })
    data.links = data.links.concat(arry)

    setLinksMap(obj)

    // 隐藏当前表直接上下游表血缘
    arry.forEach(a => {
      const index = data.links.findIndex(link => link.id === a.id)
      data.links.splice(index, 1)
    })
  }

  // 展开全部字段，隐藏表血缘
  const hiddenTableLineage1 = () => {
    const arry = data.links.filter(t => {
      const sourceNode = _.cloneDeep(data.nodes.find(n => n.id === t.relU))
      const targetNode = data.nodes.find(n => n.id === t.relV)

      if (targetNode.type !== 2) {
        sourceNode.DownIsTable = false
      } else {
        sourceNode.DownIsTable = true
      }
     
      return !sourceNode.DownIsTable && (!t.u && !t.v)
    })
    
    const obj = Object.assign({}, linksMap)
    data.nodes.forEach(node => {
      const tableId = node.id
      obj[tableId] = data.links.filter(t => {
        return (t.relU === tableId || t.relV === tableId)
      })
    })
    // data.links = data.links.concat(arry)
    setLinksMap(obj)

    // 隐藏当前表直接上下游表血缘
    // arry.forEach(a => {
    //   const index = data.links.findIndex(link => link.id === a.id)
    //   data.links.splice(index, 1)
    // })
  }

  // 收起全部字段，显示表血缘
  const showTableLineage = () => {
    // linksMap.keys()
    const tableIds = Object.keys(linksMap)
    tableIds.forEach(tableId => {
      linksMap[`${tableId}`].forEach(t => {
        const nodesArry = data.nodes
          .filter(node => node.id !== tableId && (node.id === t.relU || node.id === t.relV))
          // .filter(node => node.id !== tableId)
        // 当上下游节点为收起状态：isFold = true时，添加表关系，否则不添加
        if (nodesArry.length > 0 && nodesArry[0].isFold) {
          data.links.splice(0, 0, t)
        }
      })
    })

  }

//   useEffect(() => {
//     data.nodes.forEach(table => {
//       table.isFold = !store.isUnfoldAll
//       return table
//     })
//     // 展开所有字段，过滤links的表血缘
//     if (store.isUnfoldAll) {
//       // hiddenTableLineage()
//       hiddenTableLineage1()
//     } else {
//       showTableLineage()
//     }
//     data.nodes = _.uniqBy(data.nodes, 'id')
//     data.links = _.uniqBy(data.links, 'id')
//     setData({...data})
  
// }, [store.isUnfoldAll])

  // 初始化最多三层，当前表收起isExpand为true，其他表 false
  // useEffect(() => {
  //   const newData = getInit(props)
  //   setData({...newData})
  // }, [props.nodes])

  // useEffect(() => {
  //   if (cvsRef.current) {
  //     cvsRef.current.zoom(store.curScale)
  //   }
  // }, [store.curScale])

  // useEffect(() => {
  //   if (cvsRef.current) {
  //     cvsRef.current.zoom(1)
  //     store.curScale = 1
  //     cvsRef.current.getOrigin()
  //     cvsRef.current.setOrigin(['50%', '50%'])
  //     cvsRef.current.focusCenterWithAnimate()
  //   }
  // }, [store.focusFlag])
  return (
    <div className="lineage-box pl16">
      <LineageTable
        {...data}
        options={{}}
        loopNum={0}
        onItemClick={item => {
          // openInfoContent()
          // const {name, descr} = item
          // const itemId = item.id.split('@')[1]
          // getInfoData({
          //   id: itemId,
          //   type: 6, 
          //   needDownstream: 0,
          // })
          // getInitInfo({
          //   name,
          //   descr,
          //   type: 6,
          // })
          // store.curClassId = item.classId
          // store.curNodeId = itemId
        }}
        onLoaded={canvas => {
          cvsRef.current = canvas
          // store.refreshLineage()
        }}
        onEachFrame={() => {
          if (!cvsRef.current) {
            return
          }
          if (relayout) {
            cvsRef.current.relayout()
            setRelayout(false)
          }

          if (focus) {
            cvsRef.current.focusNode(focus)
            setFocus(false)
          }
        }}
      />
    </div>
  )
}

export default Page
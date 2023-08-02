import React, { useState, useEffect, useMemo } from 'react'
import { Link } from 'react-router-dom'
import { Tree, Dropdown, Tag, message, Modal } from 'antd'
import { MoreOutlined, DeleteOutlined, TableOutlined, DatabaseOutlined, FunctionOutlined, FolderViewOutlined, ExclamationCircleFilled } from '@ant-design/icons'
import io from '@common/io-context'
import ModalAddTable from './modal-add-table'
import ModalAddFunction from './modal-add-function'
import ModalApplyFunction from './modal-apply-function'

const { confirm } = Modal
// It's just a simple demo. You can use tree map to optimize update perf.
const updateTreeData = (list, key, children) => 
  list.map((node) => {
    if (node.key === key) {
      return {
        ...node,
        children,
      };
    }
    if (node.children) {
      return {
        ...node,
        children: updateTreeData(node.children, key, children),
      };
    }
    return node;
})

const Cm = (props) => {
  const {
    catalogDetail,
    databaseList=[],
    databaseFunList,
    databaseTableList,
    type,
    getChildren,
    databaseName,
    itemId,
    getCatalogDetail,
    getDatabases,
  } = props

  const initExpandedKeys = useMemo(() => [databaseName || catalogDetail.defaultDatabase], [databaseName, catalogDetail.defaultDatabase])
  const initSelectedKeys = useMemo(() => [itemId], [itemId])
  const [treeData, setTreeData] = useState([])
  const [expandedKeys, setExpandedKeys] = useState([])
  const [selectedKeys, setSelectedKeys] = useState([])
  const [addTableVisible, setAddTableVisible] = useState(false)
  const [addFunVisible, setAddFunVisible] = useState(false)
  const [applyFunVisible, setApplyFunVisible] = useState(false)
  const [curDatabase, setCurDatabase] = useState('')
  const [defaultDatabase, setDefaultDatabase] = useState(databaseName || catalogDetail.defaultDatabase)
  const [functionList, setFunctionList] = useState([])
  const [formValues, setFormValues] = useState([])
  
  const iconMap = {
    database: <DatabaseOutlined />,
    table: <TableOutlined />,
    view: <FolderViewOutlined />,
    function: <FunctionOutlined />
  }

  const initTreeData = useMemo(() => {
    return databaseList?.map(t => {
      console.log(defaultDatabase)
      return {
        title: t,
        key: t,
        icon: <DatabaseOutlined />,
        default: catalogDetail.defaultDatabase === t,
        oparations: 'more',
        type: 'database'
      }
    })
  }, [databaseList, defaultDatabase])
  
  const setDatabaseDefault = async node => {
    // console.log('----setDatabaseDefault----', node)
    try {
      const res = await io.put(`/catalogs/${catalogDetail.catalogId}/databases/${node.key}/default`)
      // console.log('----setDatabaseDefault----', res)
      setDefaultDatabase(node.title)
      res && getCatalogDetail() && getDatabases()
    } catch (error) {
      message.error(error)
    }
  }

  const addTable = async node => {
    setCurDatabase(node.title)
    setAddTableVisible(true)
  }

  const delTable =  node => {
    // console.log('----delTable----', node)
    confirm({
      title: 'Do you Want to delete this table?',
      icon: <ExclamationCircleFilled />,
      onOk: async () => {
        try {
          const res = await io.delete(`/catalogs/${catalogDetail.catalogId}/databases/${node.database}/tables/${node.id}`)
          window.location.hash = `/catalog/${catalogDetail.catalogId}`
          res && onLoadData(node.database)
        } catch (error) {
          message.error(error)
        }
      },
      onCancel: () => {
        console.log('Cancel')
      },
    })
  }

  const addFunction = node => {
    setCurDatabase(node.title)
    setAddFunVisible(true)
  }

  const confirmApplyFunction = (params) => {
    setFormValues(params)
  }

  const delFunction = node => {
    console.log('----delFunction----')
    confirm({
      title: `Do you Want to delete this function?`,
      icon: <ExclamationCircleFilled />,
      onOk: async () => {
        try {
          const res = await io.delete(`/catalogs/${catalogDetail.catalogId}/databases/${node.database}/functions/${node.id}`)
          window.location.hash = `/catalog/${catalogDetail.catalogId}`
          res && onLoadData(node.database)
        } catch (error) {
          message.error(error)
        }
      },
      onCancel: () => {
        console.log('Cancel')
      },
    })
  }

  const tableItems = node => [
    {
      key: 'setDefault',
      label: (<span onClick={() => setDatabaseDefault(node)}>set default</span>),
    },
    {
      key: 'createTable',
      label: (<span onClick={() => addTable(node)}>create table</span>),
    },
  ]
  
  const functionItems = node => [
    {
      key: 'setDefault',
      label: (<span onClick={() => setDatabaseDefault(node)}>set default</span>),
    },
    {
      key: 'createFunction',
      label: (<span onClick={() => addFunction(node)}>create function</span>),
    },
  ]

  const getOparation = node =>{
    const items = type === 'table' ? tableItems(node) : functionItems(node)
    const optionMap = {
      more: <Dropdown
        menu={{
          items,
        }}
        trigger={['click']}
      >
        <MoreOutlined />
      </Dropdown>,
      delete: <DeleteOutlined onClick={() => type === 'table' ? delTable(node) : delFunction(node)} />,
    }
    return optionMap[`${node.oparations}`]
  }

  const onLoadData = ({ key, children }) => {
    console.log('----onLoadData----', key)
    return getChildren(key)
    .then((resolve=[], reject) => {
      if (children) {
        return;
      }
      setTimeout(() => {
        setTreeData((origin) =>
          updateTreeData(origin, key, 
            resolve.map((t, i) => {
              return type === 'table' ? 
                {database: key, title: t.tableName, id: t.tableName, key: `${key}-${t.tableName}`, oparations: 'delete',type: 'table', icon: <span style={{verticalAlign: 'sub'}}>{iconMap['table']}</span>, isLeaf: true}
                :
                {database: key, title: t.functionName, id: t.functionId, key: `${key}-${t.functionId}`, oparations: 'delete', type: 'function', icon: <span style={{verticalAlign: 'sub'}}>{iconMap['function']}</span>, isLeaf: true}
            })
          ),
        )
      }, 1000)
    })
  }

  const onExpand = (expandedKeysValue) => {
    setExpandedKeys(expandedKeysValue);
  }

  const onSelect = (selectedKeysValue, info) => {
    setSelectedKeys(selectedKeysValue);
  }

  useEffect(() => {
    setTreeData(initTreeData)
  }, [databaseList, defaultDatabase])

  useEffect(() => {
    setExpandedKeys(initExpandedKeys)
    setSelectedKeys(initSelectedKeys)
  }, [databaseName])

  const ModalAddTableProps = {
    visible: addTableVisible,
    curDatabase,
    databaseList,
    catalogDetail,
    onLoadData,
    switchVisible: setAddTableVisible,
    onCancel: () => setAddTableVisible(false),
  }

  const ModalAddFunProps = {
    visible: addFunVisible,
    curDatabase,
    databaseList,
    formValues,
    catalogDetail,
    onLoadData,
    switchVisible: setAddFunVisible,
    analysisCallback: params => {
      setFunctionList(params.functionList)
    },
    switchApplyFunVisible: setApplyFunVisible,
  }

  const ModalApplyFunProps = {
    visible: applyFunVisible,
    functionList,
    switchVisible: setApplyFunVisible,
    onOk: (params) => confirmApplyFunction(params),
  }

  return (
    <div className='mt16 left-tree'>
      <Tree
        showIcon
        blockNode
        expandedKeys={expandedKeys}
        onExpand={onExpand}
        onSelect={onSelect}
        selectedKeys={selectedKeys}
        loadData={(node) => onLoadData(node, databaseFunList)}
        treeData={treeData}
        // icon={node => <span className='mt4 mb4' style={{verticalAlign: 'baseline'}}>{iconMap[`${node.type}`]}</span>}
        titleRender={node => (
          node.type !== 'database' ? 
            <div className='FBH FBJ mt4 mb4' style={{display: 'inline-flex'}}>
              <Link className='fc85' 
              to={`/catalog/${catalogDetail.catalogId}/${node.database}/${type}/${node.id}`}
              state={{title: node?.title}}
              >
                <div className='omit' style={{width: 175}}>
                  {node.title} {node.default && <Tag>default</Tag>}
                </div>
              </Link>
              <div>
                {getOparation(node)}
              </div>
            </div>
          : 
          <div className='FBH FBJ' style={{display: 'inline-flex'}}>
            <div style={{width: 200}}>
              {node.title} {node.default && <Tag>default</Tag>}
            </div>
            <div>
              {getOparation(node)}
            </div>
          </div>
        )}
      />
      <ModalAddTable {...ModalAddTableProps} />
      <ModalAddFunction {...ModalAddFunProps} />
      <ModalApplyFunction {...ModalApplyFunProps} />
    </div>
  )
}
export default Cm
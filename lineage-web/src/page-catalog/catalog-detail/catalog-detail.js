import React, { useState, useEffect } from 'react'
import { useParams, Outlet } from 'react-router-dom'
import { message, Tabs, Breadcrumb, Empty, Dropdown } from 'antd'
import { TableOutlined, FunctionOutlined, PlusSquareOutlined } from '@ant-design/icons'
import DetailTree from './detail-tree'
import ModalAddDatabase from './modal-add-database'
import io from '@common/io-context'
import ModalAddTable from './modal-add-table'
import ModalAddFunction from './modal-add-function'
import ModalApplyFunction from './modal-apply-function'

const Cm = () => {
  const { id: catalogId, databaseName, itemId } = useParams()
  const [catalogDetail, setCatalogDetail] = useState({})
  const [databaseList, setDatabaseList] = useState([])
  const [databaseFunList, setDatabaseFunList] = useState([])
  const [databaseTableList, setDatabaseTableList] = useState([])
  const [activeKey, setActiveKey] = useState('table')
  const [addDatabaseVisible, setAddDatabaseVisible] = useState(false)
  const [addTableVisible, setAddTableVisible] = useState(false)
  const [addFunVisible, setAddFunVisible] = useState(false)
  const [applyFunVisible, setApplyFunVisible] = useState(false)
  const [curDatabase, setCurDatabase] = useState('')
  const [formValues, setFormValues] = useState([])
  const [functionList, setFunctionList] = useState([])

  // get catalog detail
  const getCatalogDetail = async () => {
    try {
      const res = await io.get(`/catalogs/${catalogId}`)
      setCatalogDetail(res)
    } catch (error) {
      message.error(error)
    }
  }

  // get databases under this catalog
  const getDatabases = async () => {
    try {
      const res = await io.get(`/catalogs/${catalogId}/databases`)
      console.log('0000', res)
      setDatabaseList(res || [])
    } catch (error) {
      message.error(error)
    }
  }

  // get databases under this catalog
  const getDatabasesFun = async databaseName => {
    try {
      const res = await io.get(`/catalogs/${catalogId}/databases/${databaseName}/functions`)
      setDatabaseFunList(res.list?.map(t => { return { title: t.functionName, key: t.functionId } }))
      return res.list
    } catch (error) {
      message.error(error)
    }
  }

  // get databases under this catalog
  const getDatabasesTable = async databaseName => {
    try {
      const res = await io.get(`/catalogs/${catalogId}/databases/${databaseName}/tables`)
      setDatabaseTableList(res)
      return res
    } catch (error) {
      message.error(error)
    }
  }

  const onChangeTab = (val) => {
    setActiveKey(val)
  }

  const addDatabase = () => {
    console.log(11)
  }

  const confirmApplyFunction = (params) => {
    setFormValues(params)
  }

  useEffect(() => {
    getCatalogDetail()
    getDatabases()
  }, [])

  const tabsMap = {
    table: getDatabasesTable,
    function: getDatabasesFun,
  }

  const DetailTreeProps = {
    catalogDetail,
    databaseList,
    databaseFunList,
    databaseTableList,
    type: activeKey,
    getChildren: tabsMap[activeKey],
    databaseName,
    itemId,
    getCatalogDetail,
    getDatabases,
  }

  const DetaiInfoProps = {
    catalogDetail,
    databaseName,
    itemId,
  }

  const items = [
    {
      key: '1',
      label: (
        <span className='hand' onClick={() => setAddDatabaseVisible(true)}>
          Create database
        </span>
      ),
    },
    {
      key: '2',
      label: (
        <span className='hand' onClick={() => setAddTableVisible(true)}>
          Create table
        </span>
      ),
    },
    {
      key: '3',
      label: (
        <span className='hand' onClick={() => setAddFunVisible(true)}>
          Create function
        </span>
      ),
    },
  ]

  const modalAddDatabaseProps = {
    catalogId,
    visible: addDatabaseVisible,
    switchVisible: setAddDatabaseVisible,
    callback: getDatabases,
    getCatalogDetail,
  }

  const ModalAddTableProps = {
    visible: addTableVisible,
    curDatabase,
    databaseList,
    catalogDetail,
    // onLoadData,
    switchVisible: setAddTableVisible,
    onCancel: () => setAddTableVisible(false),
  }

  const ModalAddFunProps = {
    visible: addFunVisible,
    curDatabase,
    databaseList,
    formValues,
    catalogDetail,
    // onLoadData,
    switchVisible: setAddFunVisible,
    analysisCallback: params => {
      setFunctionList(params.functionList)
    },
    switchApplyFunVisible: setApplyFunVisible,
  }

  const ModalApplyFunProps = {
    functionList,
    visible: applyFunVisible,
    switchVisible: setApplyFunVisible,
    onOk: (params) => confirmApplyFunction(params),
  }

  return (
    <div className='FBH FBJ'>
      <div className='left-tree-box white-bg p16'>
        <div className='FBH FBJ'>
          <Breadcrumb separator="<">
            <Breadcrumb.Item href="#/catalog">Catalogs</Breadcrumb.Item>
            <Breadcrumb.Item>{catalogDetail?.catalogName || '--'}</Breadcrumb.Item>
          </Breadcrumb>
          <Dropdown
            menu={{
              items,
            }}
          >
            <PlusSquareOutlined className='fs16 fc7 hand' />
          </Dropdown>
        </div>
        <Tabs
          defaultActiveKey="table"
          items={[{
            label: <span><TableOutlined />Table</span>,
            key: 'table',
            children: <DetailTree {...DetailTreeProps} />,
          }, {
            label: <span><FunctionOutlined />Funtion</span>,
            key: 'function',
            children: <DetailTree {...DetailTreeProps} />,
          }]}
          activeKey={activeKey}
          onChange={onChangeTab}
        />
      </div>
      <div className='white-bg' style={{ width: '100%' }}>
        {
          itemId ? <Outlet context={{ ...DetaiInfoProps }} /> : <Empty />
        }
      </div>
      <ModalAddDatabase {...modalAddDatabaseProps} />
      <ModalAddTable {...ModalAddTableProps} />
      <ModalAddFunction {...ModalAddFunProps} />
      <ModalApplyFunction {...ModalApplyFunProps} />
    </div>
  )
}
export default Cm
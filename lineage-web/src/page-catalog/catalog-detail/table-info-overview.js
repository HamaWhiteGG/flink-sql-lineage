import React,{useState, useEffect} from 'react'
import { Collapse, Table, Checkbox, message, Typography} from 'antd'
import io from '@common/io-context'

const { Panel } = Collapse
const { Text } = Typography
const Cm = (props) => {
  const {catalogId, tableName, databaseName} = props
  const [activeKey, setActiveKey] = useState('schema')
  const [columnList, setColumnList] = useState([])
  const [parametersList, setParametersList] = useState([])
 
  const schemaColumn = [{
    key: 'columnName',
    dataIndex: 'columnName',
    title: 'Column Name'
  },
  {
    key: 'columnType',
    dataIndex: 'columnType',
    title: 'Column Type'
  },
  {
    key: 'comment',
    dataIndex: 'comment',
    title: 'Comment',
    render: (text, record) => {
      return <span>{text ||  <Text type="secondary">--</Text>}</span>
    }
  },
  {
    key: 'primaryKey',
    dataIndex: 'primaryKey',
    title: 'Primary Key',
    align: 'center',
    render: (text, record) => {
      return <Checkbox key={record.columnName} onChange={onChangeCheckBox} />
    }
  },
  {
    key: 'watermark',
    dataIndex: 'watermark',
    title: 'Watermark',
    render: (text, record) => {
      return <span>{text ||  <Text type="secondary">--</Text>}</span>
    }
  },]

  const parametersColumn = [{
    key: 'key',
    dataIndex: 'key',
    title: 'Key'
  },{
    key: 'value',
    dataIndex: 'value',
    title: 'Values'
  },]

  const getTableInfos = async () => {
    try {
      const res = await io.get(`/catalogs/${catalogId}/databases/${databaseName}/tables/${tableName}`)
      const {columnList = [], propertiesMap = []} = res
      const tmpPropertiesMap = Object.keys(propertiesMap).map(t => {
        return {
          key: t,
          value: propertiesMap[t]
        }
      })
      setColumnList(columnList)
      setParametersList(tmpPropertiesMap)
    } catch (error) {
      message.error(error)
    }
  }

  const onChangeCheckBox = (e) => {
    console.log(`checked = ${e.target.checked}`)
  }

  const onChange = (key) => {
    setActiveKey(key)
  }

  useEffect(() => {
    tableName && getTableInfos()
  }, [tableName])
  
  return (
    <div className='gray-bg pt8'>
      <Collapse ghost onChange={onChange} activeKey={activeKey}>
        <Panel className='white-bg' header="table schema" key="schema">
          <Table columns={schemaColumn} dataSource={columnList} />
        </Panel>
        <Panel className='white-bg' header="table parameters" key="parameters">
          <Table columns={parametersColumn} dataSource={parametersList} />
        </Panel>
      </Collapse>
    </div>
  )
}
export default Cm